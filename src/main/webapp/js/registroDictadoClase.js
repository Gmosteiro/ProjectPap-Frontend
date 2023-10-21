document.addEventListener("DOMContentLoaded", function () {
  const URL = "/Gimnasio_Web/RegistroDictadoClase";
  const actividadSelect = document.getElementById("actividad");
  const buscarClasesButton = document.getElementById("buscarClasesButton");
  const institucionSelect = document.getElementById("institucion");

  // Realizar una solicitud a la API
  fetch(URL)
    .then((response) => response.json()) // Analizar la respuesta como JSON
    .then((data) => {
      // Iterar sobre los datos y crear opciones para el select
      const instituciones = data.Instituciones;
      instituciones.forEach((item) => {
        const option = document.createElement("option");
        option.value = item.nombre; // Asigna el valor deseado
        option.textContent = item.nombre; // Asigna el texto deseado
        institucionSelect.appendChild(option);
      });
    })
    .catch((error) => {
      console.error("Error al obtener datos de la API:", error);
    });

  actividadSelect.addEventListener("click", function () {
    // Obtiene el valor seleccionado

    const selectedValue = actividadSelect.value;
    const nombreInstitucion = document.getElementById("institucion").value;

    if (selectedValue === "Select" && actividadSelect.options.length == 1) {
      fetch(`${URL}?nombreInstitucion=${nombreInstitucion}`)
        .then((response) => response.json()) // Analizar la respuesta como JSON
        .then((data) => {
          // Iterar sobre los datos y crear opciones para el select

          const actividades = data.Actividades;
          actividades.forEach((item) => {
            const option = document.createElement("option");
            option.value = item.nombre; // Asigna el valor deseado
            option.textContent = item.nombre; // Asigna el texto deseado
            actividadSelect.appendChild(option);
          });
        })
        .catch((error) => {
          console.error("Error al obtener datos de la API:", error);
        });
    } else {
    }
  });

  // Agrega un controlador de eventos al botón
  buscarClasesButton.addEventListener("click", function () {
    // Obtén el valor seleccionado en el select
    const actividadSeleccionada = actividadSelect.value;
    if (actividadSeleccionada !== null && actividadSeleccionada !== "Select") {
      // Realiza una solicitud fetch al servlet GetClases
      fetch(
        `GetClases?nombreActividad=${actividadSeleccionada}&tablaconaccion=${actividadSeleccionada}`
      )
        .then((response) => {
          if (!response.ok) {
            throw new Error("La solicitud a getClases falló");
          }
          return response.text();
        })
        .then((data) => {
          document.getElementById("tablaClases").innerHTML = data;
          debugger;
          document.getElementsByClassName(
            "clases-info-custom mt-2"
          )[0].style.display = "block";
        })
        .catch((error) => {
          console.error("Error en la solicitud:", error);
        });
    }
  });
});
