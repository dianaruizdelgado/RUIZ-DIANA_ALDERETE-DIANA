import java.util.List;
import model.Odontologo;
import dao.OdontologoDAO;
import dao.OdontologoDAOArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class OdontologoDAOArrayListTest {
    private OdontologoDAO dao;

    @Before
    public void setUp() {
        dao = new OdontologoDAOArrayList();
    }

    @Test
    public void testGuardarYListar() {
        Odontologo odontologo1 = new Odontologo(1, "Juan", "Pérez");
        Odontologo odontologo2 = new Odontologo(2, "Ana", "Gómez");

        dao.guardar(odontologo1);
        dao.guardar(odontologo2);

        List<Odontologo> odontologos = dao.listarTodos();
        assertEquals(2, odontologos.size());
    }
}
