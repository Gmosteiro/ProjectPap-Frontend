document.addEventListener("DOMContentLoaded", function () {
  const consultarClases = document.getElementById("consultar-clases-custom");
  const clasesInfo = document.querySelector(".clases-info-custom");
  const consultarActividades = document.getElementById(
    "consultar-actividades-custom"
  );
  const actividadesInfo = document.querySelector(".actividades-info-custom");

  const buttonEditar = document.getElementById("editarBtn");

  consultarClases.addEventListener("click", function () {
    if (clasesInfo.style.display === "none") {
      clasesInfo.style.display = "block";
    } else {
      clasesInfo.style.display = "none";
    }
  });

  if (consultarActividades) {
    consultarActividades.addEventListener("click", function () {
      if (actividadesInfo.style.display === "none") {
        actividadesInfo.style.display = "block";
      } else {
        actividadesInfo.style.display = "none";
      }
    });
  }

  buttonEditar.addEventListener("click", function () {
    document.getElementById("nombre").style.display = "none";
    document.getElementById("apellido").style.display = "none";
    document.getElementById("fechaNacimiento").style.display = "none";
    document.getElementById("nombreInput").style.display = "inline";
    document.getElementById("apellidoInput").style.display = "inline";
    document.getElementById("fechaNacimientoInput").style.display = "inline";
    document.getElementById("aceptarBtn").style.display = "inline";
    document.getElementById("editarBtn").style.display = "none";
    document.getElementById("cancelarBtn").style.display = "inline";
  });

  document.getElementById("cancelarBtn").addEventListener("click", function () {
    document.getElementById("nombre").style.display = "inline";
    document.getElementById("apellido").style.display = "inline";
    document.getElementById("fechaNacimiento").style.display = "inline";
    document.getElementById("nombreInput").style.display = "none";
    document.getElementById("apellidoInput").style.display = "none";
    document.getElementById("fechaNacimientoInput").style.display = "none";
    document.getElementById("aceptarBtn").style.display = "none";
    document.getElementById("editarBtn").style.display = "inline";
    document.getElementById("cancelarBtn").style.display = "none";

    document.getElementById("nombreInput").value =
      document.getElementById("nombre").innerText;
    document.getElementById("apellidoInput").value =
      document.getElementById("apellido").innerText;
    document.getElementById("fechaNacimientoInput").value =
      document.getElementById("fechaNacimiento").innerText;
  });

  document.getElementById("aceptarBtn").addEventListener("click", function () {
    const nuevoNombre = document.getElementById("nombreInput").value;
    const nuevoApellido = document.getElementById("apellidoInput").value;
    const nuevaFechaNacimiento = document.getElementById(
      "fechaNacimientoInput"
    ).value;
    const nickname = document.getElementById("nickname").innerText;

    const rawProfileImage = document.getElementById("profileImage").currentSrc;

    const parts = rawProfileImage.split(",");
    const base64Image = parts[1];

    // Realizar una solicitud Fetch para enviar los datos actualizados al servidor

    fetch("actualizarUsuario", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        nickname: nickname,
        nombre: nuevoNombre,
        apellido: nuevoApellido,
        profileImage: base64Image,
        fechaNacimiento: nuevaFechaNacimiento,
      }),
    })
      .then((response) => {
        return response.json(); // Debes agregar un return aquí.
      })
      .then((data) => {
        debugger;

        if (!data.error) {
          mostrarMensaje(
            "Ok",
            "Usuario modificado con exito!",
            nuevoNombre,
            nuevoApellido,
            nuevaFechaNacimiento
          );
        } else {
          mostrarMensaje("ERROR", data.Message);
        }
        // Manejar los datos JSON aquí
      })
      .catch((error) => {
        debugger;
        // Manejar errores en la solicitud Fetch
        console.error("Error al actualizar el perfil:" + error);
      });

    document.getElementById("nombre").style.display = "inline";
    document.getElementById("apellido").style.display = "inline";
    document.getElementById("fechaNacimiento").style.display = "inline";

    document.getElementById("nombreInput").style.display = "none";
    document.getElementById("apellidoInput").style.display = "none";
    document.getElementById("fechaNacimientoInput").style.display = "none";

    document.getElementById("aceptarBtn").style.display = "none";
  });

  const mostrarMensaje = (
    status,
    mensaje,
    nuevoNombre,
    nuevoApellido,
    nuevaFechaNacimiento
  ) => {
    const successMessage = document.getElementById("success-message");
    const errorMessage = document.getElementById("error-message");
    const nombreSpan = document.getElementById("nombre");
    const apellidoSpan = document.getElementById("apellido");
    const fechaNacimientoSpan = document.getElementById("fechaNacimiento");
    const nombreHeader = document.getElementById("nombreYapellido");

    switch (status) {
      case "ERROR":
        // Aquí asumimos que el mensaje de error está almacenado en this.mensaje
        errorMessage.innerHTML = `Error: ${mensaje}`;
        errorMessage.style.display = "block"; // Mostrar el mensaje de error
        successMessage.style.display = "none"; // Ocultar el mensaje satisfactorio
        break;

      case "Ok":
        // Aquí asumimos que el mensaje satisfactorio está almacenado en this.mensaje
        successMessage.innerHTML = mensaje;
        successMessage.style.display = "block"; // Mostrar el mensaje satisfactorio
        errorMessage.style.display = "none"; // Ocultar el mensaje de error

        // Actualizar los elementos <span> con los nuevos valores
        nombreHeader.textContent = `${nuevoNombre} ${nuevoApellido}`;
        nombreSpan.textContent = nuevoNombre;
        apellidoSpan.textContent = nuevoApellido;
        fechaNacimientoSpan.textContent = nuevaFechaNacimiento;
        break;

      default:
        break;
    }
  };
});

window.addEventListener("load", function getClasesAsociadas() {
  const userNickname = document.getElementById("userNickname").innerText;

  fetch("getClases?nickname=" + userNickname)
    .then((response) => {
      if (!response.ok) {
        throw new Error("La solicitud a getClases falló");
      }
      return response.text();
    })
    .then((data) => {
      document.getElementById("tablaClases").innerHTML = data;
    })
    .catch((error) => {
      console.error("Error en la solicitud:", error);
    });
});

window.addEventListener("load", function getActividadesAsociadas() {
  const userType = document.getElementById("userType").innerText;

  if (userType !== "Profesor") return;

  const userNickname = document.getElementById("userNickname").innerText;

  fetch("consultaActividades?nicknameUsuario=" + userNickname)
    .then((response) => {
      if (!response.ok) {
        throw new Error("La solicitud a ConsultaActividad falló");
      }
      return response.text();
    })
    .then((data) => {
      debugger;
      document.getElementById("tablaActividades").innerHTML = data;
    })
    .catch((error) => {
      console.error("Error en la solicitud:", error);
    });
});
