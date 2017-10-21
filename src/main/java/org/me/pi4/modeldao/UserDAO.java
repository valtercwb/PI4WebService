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
import org.me.pi4.database.DbPostgre;
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

    public User AuthUser(String login, String senha) {
       
       DbConnection.instancia();
       Connection con = DbConnection.instancia().getConnection();
       User u = new User();

        String chave = Cryptography.convert(senha);

        try {

            String sql = "SELECT * FROM appdatabase.usuario WHERE usu_codigo=? AND usu_senha=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, chave);
            rs = pst.executeQuery();
            while (rs.next()) {
                u.setUserCode(rs.getString("usu_codigo"));
                u.setUserName(rs.getString("usu_nome"));
                u.setUserPassword(rs.getString("usu_senha"));
                u.setUserType(rs.getInt("usu_tipo"));
                return u;
            }
            pst.close();
            rs.close();

        } catch (SQLException ex) {
        }
        return null;
    }
    
    public User AuthUserPostgre(String login, String senha) {
       
       DbPostgre.instancia();
       
       Connection con = DbPostgre.instancia().getConnection();
       User u = new User();

        //String chave = Cryptography.convert(senha);

        try {

            String sql = "SELECT * FROM usuario WHERE usu_login=? AND usu_password=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            rs = pst.executeQuery();
            while (rs.next()) {
                u.setUserCode(rs.getString("usu_login"));
                u.setUserName(rs.getString("usu_name"));
                u.setUserPassword(rs.getString("usu_password"));
                u.setUserType(rs.getInt("usu_tipo"));
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
}
