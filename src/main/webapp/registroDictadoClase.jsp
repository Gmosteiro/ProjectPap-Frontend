<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
    <title>Mi Perfil</title>
    <style>
      body {
        padding-bottom: 60px;
      }

      .tag-editar {
        align-self: center;
        margin-left: 56%;
      }

      .tag-editar:hover {
        color: blue !important;
        cursor: pointer;
      }

      .btn,
      .btn-info,
      .btn-block,
      .btn-round {
        border: 1px #0dcaf0;
        display: inline;
        max-width: 180px;
        background-color: cornsilk !important;
      }

      .btn:hover,
      .btn-info:hover,
      .btn-block:hover,
      .btn-round:hover {
        background-color: #17a2b8 !important;
      }

      .custom-col {
        max-width: 500px;
      }
      .cust-container-dropd {
        margin-left: 50px;
        display: inline-flex;
        height: fit-content;
        align-items: baseline;
        padding: 10px;
      }

      .titulo-drpd {
        margin-right: 10px;
      }
    </style>
    <script src="./js/registroDictadoClase.js"></script>
    <%@include file="/header.jsp" %>

    <script>
      const enviarInfo = (claseId) => {
        debugger;
        console.log("enviarInfo | ClaseId: " + claseId);

        var socio = "<%= usuarioLogeado.getNickname() %>";

        console.log("aver si agarra el socio: " + socio);

        const data = {
          socio: socio,
          clase: claseId,
        };

        // Realizar una solicitud POST al servidor con los datos
        fetch("RegistroDictadoClase", {
          method: "POST",
          body: JSON.stringify(data),
          headers: {
            "Content-Type": "application/json",
          },
        })
          .then(
            (response) => response.json() // Debes agregar un return aquí.
          )
          .then((data) => {
            debugger;

            if (!data.ERROR) {
              mostrarMensaje("Ok", "Registrado con exito!");
            } else {
              mostrarMensaje("ERROR", data.Message);
            }
            // Manejar los datos JSON aquí
          })
          .catch((error) => {
            console.error("Error en la solicitud POST:", error);
          });
      };

      const mostrarMensaje = (status, mensaje) => {
        debugger;
        const successMessage = document.getElementById("success-message");
        const errorMessage = document.getElementById("error-message");

        switch (status) {
          case "ERROR":
            // Aquí asumimos que el mensaje de error está almacenado en this.mensaje
            errorMessage.innerHTML = "Error: " + mensaje;
            errorMessage.style.display = "block"; // Mostrar el mensaje de error
            successMessage.style.display = "none"; // Ocultar el mensaje satisfactorio
            break;

          case "Ok":
            // Aquí asumimos que el mensaje satisfactorio está almacenado en this.mensaje
            successMessage.innerHTML = mensaje;
            successMessage.style.display = "block"; // Mostrar el mensaje satisfactorio
            errorMessage.style.display = "none"; // Ocultar el mensaje de error

            break;

          default:
            break;
        }
      };
    </script>
  </head>

  <body>
    <div class="container">
      <div class="col">
        <div class="cust-container-dropd">
          <h3 class="titulo-drpd">Instituciones</h3>

          <select
            class="form-select form-select-lg mb-3 custom-col"
            id="institucion"
            name="institucion"
          >
            <option value="Select">Seleccionar Institucion</option>
          </select>
        </div>
        <div class="cust-container-dropd">
          <h3 class="titulo-drpd">Actividades</h3>

          <select
            class="form-select form-select-lg mb-3 custom-col"
            id="actividad"
            name="actividad"
          >
            <option value="Select">Seleccionar Actividad</option>
          </select>
        </div>
        <div class="cust-container-dropd">
          <button
            id="buscarClasesButton"
            style="width: 120px"
            type="submit"
            class="btn btn-info btn-block btn-round"
          >
            Buscar
          </button>
        </div>
      </div>
      <div class="clases-info-custom mt-2" style="display: none">
        <h3>Clases:</h3>
        <div id="tablaClases"></div>
      </div>

      <div
        class="alert alert-danger"
        id="error-message"
        style="display: none"
      ></div>

      <div
        class="alert alert-success"
        id="success-message"
        style="display: none"
      ></div>
    </div>
    <%@include file="/footer.jsp" %>
  </body>
</html>
