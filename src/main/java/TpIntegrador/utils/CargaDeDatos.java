package TpIntegrador.utils;

import TpIntegrador.domain.Carrera;
import TpIntegrador.domain.Estudiante;
import TpIntegrador.domain.Estudiante_Carrera;
import TpIntegrador.repository.CarreraRepository;
import TpIntegrador.repository.EstudianteRepository;
import TpIntegrador.repository.Estudiante_CarreraRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@Component
public class CargaDeDatos {

    private final CarreraRepository carreraRepository;
    private final Estudiante_CarreraRepository estudiante_carreraRepository;
    private final EstudianteRepository estudianteRepository;

    @Autowired
    public CargaDeDatos(CarreraRepository carreraRepository, Estudiante_CarreraRepository estudiante_carreraRepository, EstudianteRepository estudianteRepository) {
        this.carreraRepository = carreraRepository;
        this.estudiante_carreraRepository = estudiante_carreraRepository;
        this.estudianteRepository = estudianteRepository;
    }

    public void cargarDatosDesdeCSV() throws IOException {

        File carreraCSV = ResourceUtils.getFile("src/main/java/TpIntegrador/csv/carreras.csv");
        File estudianteCSV = ResourceUtils.getFile("src/main/java/TpIntegrador/csv/estudiantes.csv");
        File estudiante_CarreraCSV = ResourceUtils.getFile("src/main/java/TpIntegrador/csv/estudianteCarrera.csv");

        try (FileReader reader = new FileReader(carreraCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                Carrera carrera = new Carrera();
                carrera.setNombre(csvRecord.get("carrera"));
                carrera.setDuracion(Integer.parseInt(csvRecord.get("duracion")));
                carreraRepository.save(carrera);
            }
        }
        try (FileReader reader = new FileReader(estudianteCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                Estudiante estudiante = new Estudiante();
                estudiante.setDni(Integer.parseInt(csvRecord.get("DNI")));
                estudiante.setNombre(csvRecord.get("nombre"));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setLu(Integer.parseInt(csvRecord.get("LU")));
                estudiante.setCiudad(csvRecord.get("ciudad"));
                estudiante.setGenero(csvRecord.get("genero"));
                estudianteRepository.save(estudiante);
            }
        }

        try (FileReader reader = new FileReader(estudiante_CarreraCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                Estudiante_Carrera estudianteCarrera = new Estudiante_Carrera();
                estudianteCarrera.setAnio_graduacion(Integer.parseInt(csvRecord.get("graduacion")));
                estudianteCarrera.setAnio_inscripcion(Integer.parseInt(csvRecord.get("inscripcion")));
                estudianteCarrera.setAntiguedad(Integer.parseInt(csvRecord.get("antiguedad")));

                int idCarrera = Integer.parseInt(csvRecord.get("id_carrera"));
                int idEstudiante = Integer.parseInt(csvRecord.get("id_estudiante"));

                Optional<Carrera> carreraOpt = carreraRepository.findById(Long.valueOf(idCarrera));

                Optional<Estudiante> estudianteOpt = estudianteRepository.findById(Long.valueOf(idEstudiante));

                if (carreraOpt.isPresent() && estudianteOpt.isPresent()) {
                    estudianteCarrera.setCarrera(carreraOpt.get());
                    estudianteCarrera.setEstudiante(estudianteOpt.get());
                    estudiante_carreraRepository.save(estudianteCarrera);
                } else {
                    System.out.println("Error: carrera o estudiante no encontrado para id_carrera = " + idCarrera + ", id_estudiante = " + idEstudiante);
                }


            }
        }
    }
}
