package org.me.pi4.modeldao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.me.pi4.database.DbConnection;
import org.me.pi4.model.Patient;
import org.me.pi4.model.User;
import org.me.util.Cryptography;

/**
 * @author 2016203311
 */
public class UserDAO extends DAO {

    public static boolean isUniqUserLogin = false;

    public UserDAO() {
        super();
    }

    public User autenticarUsername(String login) {

       DbConnection.instancia();
       Connection con = DbConnection.instancia().getConnection();
        User u = null;
       try {

            String sql = "SELECT * FROM usuario WHERE usu_codigo = ?  ";
            pst = con.prepareStatement(sql);
            pst.setString(1, login);
            rs = pst.executeQuery();
            if (rs.next()) {
                if(login.equals(rs.getInt(1))){
                u.setUserName(rs.getString("usu_nome"));
                u.setUserCode(rs.getString("usu_codigo"));
                }
                return u;
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {

        }
        return null;
        
    }

    public User AuthUser(String login, String senha) {
       
       DbConnection.instancia();
       Connection con = DbConnection.instancia().getConnection();
       User u = new User();
        System.out.println(senha);

        //String chave = Cryptography.convert(senha);
        System.out.println(senha);//chave

        try {

            String sql = "SELECT usu_codigo, usu_senha, usu_nome FROM appdatabase.usuario WHERE usu_codigo=? AND usu_senha=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);//chave
            rs = pst.executeQuery();
            while (rs.next()) {
                if(rs.getString(1).equals(login) && rs.getString(2).equals(senha)){
                u.setUserCode(rs.getString("usu_codigo"));
                u.setUserName(rs.getString("usu_nome"));
                }
                return u;
            }
            pst.close();
            rs.close();

        } catch (SQLException ex) {
        }
        return null;
    }

    public void addUser(Connection con, User user) throws SQLException {

        if (isUniqUser(user)) {

            try {

                String sql = "INSERT INTO Usuario (usu_nome, usu_login, usu_senha,usu_status,usu_tipo) VALUES (?, ?,MD5(?),?,?)";

                pst = con.prepareStatement(sql);

                // set parameters, then execute insertNewPerson
//                pst.setString(1, user.getUserName());
//                pst.setString(2, user.getUserLogin());
//                pst.setString(3, user.getUserSenha());
//                pst.setInt(4, user.getUserStatus().getUserStatusId());
//                pst.setInt(5, user.getUserType().getUserTypId());
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
            }
        }
    }

    public int updateUser(Connection con, User user, int resultado) {

        try {
            String sql = "UPDATE usuario SET usu_nome =?, usu_login =?, usu_senha =MD5(?), usu_status =?, usu_tipo =? WHERE usu_codigo =?";

            pst = con.prepareStatement(sql);
//            pst.setString(1, user.getUserName());
//            pst.setString(2, user.getUserLogin());
//            pst.setString(3, user.getUserSenha());
//            pst.setInt(4, user.getUserStatus().getUserStatusId());
//            pst.setInt(5, user.getUserType().getUserTypId());
//            pst.setInt(6, resultado);
            return pst.executeUpdate();

        } catch (SQLException ex) {
            return 0;
        }
    }

    /**
     * Delete user
     *
     * @param userId
     */
    public int DeleteUser(int userId) {

        try {
            pst = con.prepareStatement(
                    "DELETE FROM usuario "
                    + "WHERE usu_codigo = ?"
            );
            pst.setInt(1, userId);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            return 0;
        }
    }

    //  Verificar se usuário já está registrado na base de dados atravês do login
    public boolean isUniqUser(User user) {

        boolean isUniqCode = false;
        isUniqUserLogin = isUniqCode;

        try {
            pst = con.prepareStatement("select * from usuario where usu_login = ?");
            // pst.setString(1, user.getUserLogin());
            rs = pst.executeQuery();
            while (rs.next()) {
//                Alert msg = new Alert(Alert.AlertType.WARNING);
//                msg.setHeaderText("Aviso");
//                msg.setContentText("Já existe um usuario cadastrado com esse login");
//                msg.show();
//                return isUniqCode;
            }

            rs.close();
            pst.close();
            isUniqCode = true;
            isUniqUserLogin = isUniqCode;

        } catch (SQLException e) {

        }
        return isUniqCode;
    }

    public static void getUser(Connection conector, ArrayList<User> list) {

        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT A.usu_codigo,"
                    + "A.usu_nome, "
                    + "A.usu_login, "
                    + "C.tipo_usu_nome "
                    + "FROM sistemabrasduto.usuario A "
                    + "INNER JOIN usuario_status B "
                    + "ON (A.usu_status = B.usu_sta_codigo) "
                    + "INNER JOIN tipo_usuario C "
                    + "ON (A.usu_tipo = C.tipo_usu_codigo) "
            );

            while (resultado.next()) {
                list.add(
                        new User( //                      resultado.getInt("usu_codigo"),
                        //                                resultado.getString("usu_nome"),
                        //                                resultado.getString("usu_login"),
                        //                                resultado.getString("usu_senha")//,
                        //                                new UserStatus(resultado.getInt("usu_status"),
                        //                                resultado.getString("usu_sta_nome")),
                        //                                new UserType(resultado.getInt("usu_tipo"),
                        //                                        resultado.getString("tipo_usu_nome")))
                        ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
