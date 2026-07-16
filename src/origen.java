void main() {
    println("""
        ===========================================
        |   SISTEMA DE MATRICULA - PUCE TEC       |
        |      Carrera de Desarrollo de Software  |
        ===========================================
        """);

    String usr = "";
    String m1 = "Fundamentos de Programación";
    double n1 = 0.0;

    usr = readln("Ingrese el nombre del estudiante: ");
    String op = readln("¿Es estudiante de reingreso o arrastre? (S/N): ");

    String[] h_materias = null;

    if (op.equalsIgnoreCase("S")) {
        h_materias = new String[]{ m1 };
        String inputNota = readln("Ingrese la nota final obtenida en '" + m1 + "' (0-10): ");
        n1 = Double.parseDouble(inputNota);
    } else {
        println("-> Registrando como estudiante de Primer Semestre...");
    }

    println("\n--- MATERIA A SOLICITAR ---");
    println("Materia destino: [ Estructuras de Datos ] (Requisito: Haber aprobado Fundamentos con >= 7.0)");
    String reqCupo = readln("¿Desea solicitar el cupo para esta materia? (S/N): ");

    if (reqCupo.equalsIgnoreCase("S")) {
        boolean p1 = false;

        for (int i = 0; i < h_materias.length; i++) {
            if (h_materias[i].equals(m1)) {
                p1 = true;
            }
        }

        String resultadoMatricula = switch (String.valueOf(p1)) {
            case "true" -> {
                if (n1 >= 7.0) {
                    yield "MATRÍCULA APROBADA: Cumple con el prerrequisito.";
                } else {
                    yield "MATRÍCULA RECHAZADA: Reprobó el prerrequisito con " + n1;
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