## Fase 1: Ingeniería Inversa

**1. Problema que resuelve la aplicación:**
El sistema valida si un estudiante de la carrera de Desarrollo de Software es apto para matricularse en la materia de "Estructuras de Datos".

**2. Flujo de datos:**
* El programa solicita el nombre del estudiante y pregunta si es de reingreso o arrastre.
* Si el estudiante es de reingreso, el sistema permite ingresar la nota final obtenida en el prerrequisito ("Fundamentos de Programación"). Si es nuevo, omite este paso.
* Posteriormente, el sistema lee la confirmación de solicitud de cupo.
* Finalmente, verifica el historial académico: si encuentra el prerrequisito y la nota es mayor o igual a 7.0, aprueba la matrícula; caso contrario, se deniega la solicitud o el sistema falla por falta de datos previos.