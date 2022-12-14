package co.edu.uco.openresort.controlador;

import co.edu.uco.openresort.dto.*;
import co.edu.uco.openresort.servicio.fachada.ReservaFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/reserva")
public class ReservaControlador {

    @Autowired
    private ReservaFachada reservaFachada;

    @PostMapping("/disponibilidad/habitacion")
    public ArrayList<HabitacionDTO> consultarDisponibilidadHabitaciones(@RequestBody ConsultaDisponibilidadDTO disponibilidadDTO){
        return reservaFachada.consultarDisponibilidadHabitaciones(disponibilidadDTO);
    }

    @PostMapping("/disponibilidad/tipo")
    public ArrayList<TipoHabitacionDTO> consultarDisponibilidadTipoHabitacion(@RequestBody ConsultaDisponibilidadDTO disponibilidadDTO){
        return reservaFachada.consultarDisponibilidadTipoHabitacion(disponibilidadDTO);
    }

    @PostMapping("/disponibilidad")
    public ArrayList<RespuestaDisponibilidadDTO> consultarDisponibilidad(@RequestBody ConsultaDisponibilidadDTO disponibilidadDTO){
        return reservaFachada.obtenerListaDisponibilidad(disponibilidadDTO);
    }

    @PostMapping
    public ReservaDTO reservar(@RequestBody ReservaDTO reservaDTO) throws IOException {
        return reservaFachada.reservar(reservaDTO);
    }

    @GetMapping
    public ArrayList<ReservaDTO> consultar(){
        return reservaFachada.consultar();
    }
}
