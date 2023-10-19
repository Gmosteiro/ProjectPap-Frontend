<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
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
    </head>

    <body>
        <div class="container">


            <div class="col">
                <div class="cust-container-dropd">
                    <h3 class="titulo-drpd">Instituciones</h3>

                    <select class="form-select form-select-lg mb-3 custom-col" id="institucion" name="institucion">
                        <option value="Select">Seleccionar Institucion</option>
                    </select>
                </div>
                <div class="cust-container-dropd">

                    <h3 class="titulo-drpd">Actividades</h3>

                    <select class="form-select form-select-lg mb-3 custom-col" id="actividad" name="actividad">

                        <option value="Select">Seleccionar Actividad</option>

                    </select>
                </div>
            </div>
        </div>
        <%@include file="/footer.jsp" %>
    </body>

</html>
