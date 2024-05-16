package dao;

import model.Odontologo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class OdontologoDAOH2 implements iDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT= "INSERT INTO ODONTOLOGOS VALUES(?,?,?,?)";
    private static final String SQL_SELECT= "SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection= null;
        try{
            connection= BD.getConnection();
            logger.info("conexion establecida");
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,odontologo.getId());
            psInsert.setInt(2,odontologo.getNumeroMatricula());
            psInsert.setString(3, odontologo.getNombre());
            psInsert.setString(4, odontologo.getApellido());
            psInsert.execute();
            logger.warn("Odontologo guardado con exito");
        }catch (Exception e){
            e.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("iniciando la busqueda de todos los odontologos.....");
        Connection connection= null;
        List<Odontologo> odontologos = new ArrayList<>();
        try{
            connection= BD.getConnection();
            Statement statement= connection.createStatement();
            PreparedStatement psSelect= connection.prepareStatement(SQL_SELECT);
            ResultSet rs= psSelect.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                int matricula = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);
                Odontologo odontologo = new Odontologo(id,matricula, nombre, apellido);
                odontologos.add(odontologo);
            }

            logger.info("Listado de todos los odontologos: " + odontologos);


        }catch (Exception e){
            e.printStackTrace();
        }
        return odontologos;
    }
}
