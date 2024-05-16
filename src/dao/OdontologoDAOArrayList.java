package dao;
import dao.OdontologoDAO;
import model.Odontologo;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class OdontologoDAOArrayList implements OdontologoDAO {
    private static final Logger logger = Logger.getLogger(OdontologoDAOArrayList.class);
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public void guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        logger.info("Odontólogo guardado: " + odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Odontólogos listados");
        return new ArrayList<>(odontologos);
    }
}

