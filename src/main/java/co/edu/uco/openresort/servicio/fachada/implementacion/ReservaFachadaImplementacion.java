package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dto.*;
import co.edu.uco.openresort.servicio.ensamblador.HabitacionEnsamblador;
import co.edu.uco.openresort.servicio.ensamblador.ReservaEnsamblador;
import co.edu.uco.openresort.servicio.ensamblador.TipoHabitacionEnsamblador;
import co.edu.uco.openresort.servicio.fachada.ReservaFachada;
import co.edu.uco.openresort.servicio.servicio.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class ReservaFachadaImplementacion implements ReservaFachada {

    @Autowired
    ReservaServicio reservaServicio;

    @Override
    public ArrayList<HabitacionDTO> consultarDisponibilidadHabitaciones(ConsultaDisponibilidadDTO disponibilidadDTO) {
        return HabitacionEnsamblador.ensamblarListaDTO(reservaServicio.consultarDisponibilidadHabitaciones(disponibilidadDTO));

    }

    @Override
    public ArrayList<TipoHabitacionDTO> consultarDisponibilidadTipoHabitacion(ConsultaDisponibilidadDTO disponibilidadDTO) {
        return TipoHabitacionEnsamblador.ensamblarListaDTO(reservaServicio.consultarDisponibilidadTipoHabitacion(disponibilidadDTO));
    }

    @Override
    public ReservaDTO reservar(ReservaDTO reservaDTO) throws IOException {
        return ReservaEnsamblador.ensamblarDTO(reservaServicio.reservar(reservaDTO));
    }

    @Override
    public ArrayList<ReservaDTO> consultar() {
        return ReservaEnsamblador.ensamblarListaDTO(reservaServicio.consultar());
    }

    @Override
    public ArrayList<RespuestaDisponibilidadDTO> obtenerListaDisponibilidad(ConsultaDisponibilidadDTO disponibilidadDTO) {
        return reservaServicio.obtenerListaDisponibilidad(disponibilidadDTO);
    }
}
