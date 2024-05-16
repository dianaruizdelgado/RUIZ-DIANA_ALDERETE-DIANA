import dao.BD;
import dao.OdontologoDAOH2;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;


public class OdontologoTestService {
    @Test
    public void listarTodos(){
        BD.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        List<Odontologo> odontologos = odontologoService.buscarTodos();

    }

}
