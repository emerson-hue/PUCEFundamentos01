void main() {
    println("""
        ===========================================
        |   SISTEMA DE MATRÍCULA - PUCE TEC       |
        |      Carrera de Desarrollo de Software  |
        ===========================================
        """);

    // --- Datos del estudiante y materia base ---
    String nombreEstudiante = "";
    String materiaPrerrequisito = "Fundamentos de Programación";
    double notaPrerrequisito = 0.0;

    nombreEstudiante = readln("Ingrese el nombre del estudiante: ");
    String esReingreso = readln("¿Es estudiante de reingreso o arrastre? (S/N): ");

    String[] historialMaterias = null;

    if (esReingreso.equalsIgnoreCase("S")) {
        historialMaterias = new String[]{ materiaPrerrequisito };
        String inputNota = readln("Ingrese la nota final obtenida en '" + materiaPrerrequisito + "' (0-10): ");
        notaPrerrequisito = Double.parseDouble(inputNota);
    } else {
        println("-> Registrando como estudiante de Primer Semestre...");
        // FIX: arreglo vacío en vez de null (previene NullPointerException)
        historialMaterias = new String[]{};
    }

    println("\n--- MATERIA A SOLICITAR ---");
    println("Materia destino: [ Estructuras de Datos ] (Requisito: Haber aprobado Fundamentos con >= 7.0)");
    String reqCupo = readln("¿Desea solicitar el cupo para esta materia? (S/N): ");

    if (reqCupo.equalsIgnoreCase("S")) {
        boolean cumplePrerrequisito = false;

        // Verifica si el prerrequisito existe en el historial del estudiante
        for (int i = 0; i < historialMaterias.length; i++) {
            if (historialMaterias[i].equals(materiaPrerrequisito)) {
                cumplePrerrequisito = true;
            }
        }

        String resultadoMatricula = switch (String.valueOf(cumplePrerrequisito)) {
            case "true" -> {
                if (notaPrerrequisito == 10.0) {
                    // Nueva regla de negocio: nota perfecta = Tutor de Programación
                    yield "MATRÍCULA APROBADA: Cumple con el prerrequisito.\n"
                            + "¡Felicidades! Ha sido seleccionado como Tutor de Programación del PUCE TEC para este semestre.";
                } else if (notaPrerrequisito >= 7.0) {
                    yield "MATRÍCULA APROBADA: Cumple con el prerrequisito.";
                } else {
                    yield "MATRÍCULA RECHAZADA: Reprobó el prerrequisito con " + notaPrerrequisito;
                }
            }
            case "false" -> "MATRÍCULA RECHAZADA: No cuenta con el prerrequisito en su historial.";
            default -> "Error del sistema.";
        };

        println("\n[RESULTADO]: " + resultadoMatricula);

    } else {
        println("\nProceso finalizado. No se solicitaron materias de segundo nivel.");
    }
}