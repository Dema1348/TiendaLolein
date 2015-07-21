<%-- 
    Document   : Devolver
    Created on : 14-10-2014, 07:43:11 PM
    Author     : Alejandro
--%>

<%@page import="controlDb.MantenedoraProductosVen"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Devolución</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript">

    $(document).ready(function () {
        $('#PersonTableContainer').jtable({
            title: 'Devolución de Producto',
            actions: {
                listAction: 'CRUDController?action=list',
                createAction:'CRUDController?action=create',
                updateAction: 'CRUDController?action=update',
                deleteAction: 'CRUDController?action=delete'
            },
            fields: {
                Id_Venta: {
                 title:'ID Venta',
                    key: true,
                    list: true,
                    create:true
                },
                Id_producto: {
                    title: 'ID Poducto',
                    width: '20%',
                    edit:false
                },
                Cantidad: {
                    title: 'Cantidad',
                    width: '20%',
                    edit: true
                },  
                Precio: {
                    title: 'Precio',
                    width: '20%',
                    edit: true
                } 
            }
        });
        $('#PersonTableContainer').jtable('load');
    });
</script>
</head>
<body>
<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
<h1>Devolución de Productos</h1>
<div id="PersonTableContainer"></div>
</div>
</body>
</html>