<%-- 
    Document   : UsuarioLista
    Created on : 07/09/2014, 11:44:36
    Author     : Cliente
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1.0, maximum-scale=2.0">
	<link rel="stylesheet" type="text/css" href="../media/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css" href="../media/shCore.css">
	<link rel="stylesheet" type="text/css" href="../media/demo.css">
        <style type="text/css" class="init">
                div.container {
		width: 90%;
            	}
	</style>
	<script type="text/javascript" language="javascript" src="../media/jquery.js"></script>
	<script type="text/javascript" language="javascript" src="../media/jquery.dataTables.js"></script>
	<script type="text/javascript" language="javascript" src="../media/shCore.js"></script>
	<script type="text/javascript" language="javascript" src="../media/demo.js"></script>
	<script type="text/javascript" language="javascript" class="init">
        $(document).ready(function() {
                    $('#example').dataTable( {
                        "columnDefs": [
                            {
                                // The `data` parameter refers to the data for the cell (defined by the
                                // `data` option, which defaults to the column being worked with, in
                                // this case `data: 0`.
                                "render": function ( data, row ) {
                                    return data +' ('+ row[3]+')';
                                },
                                "targets": 0
                            },
                            { "visible": false,  "targets": [ 3 ] }
                        ]
                    } ).makeEditable({
                     aoTableActions: [
										{
										    sAction: "EditData",
										    sServerActionURL: "UpdateData.php",
										    oFormOptions: { autoOpen: false, modal: true }
										}
									],
                     sUpdateURL: "UpdateData.php",
                     sAddURL: "AddData.php",
                     sAddHttpMethod: "GET", //Used only on google.code live example because google.code server do not support POST request
                     sDeleteURL: "DeleteData.php",
                     sDeleteHttpMethod: "GET", //Used only on google.code live example because google.code server do not support POST request
                     aoColumns: [{}, {}, {}, {}, null]
                 });
                } );


	</script>
        
</head>

<body class="dt-example">
    
	<div class="container">
		<section>
                    <table id="example" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Senha</th>
						<th>Imagem</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Senha</th>
						<th>Imagem</th>
					</tr>
				</tfoot>

				<tbody>
					<tr>
						<td data-search="Tiger Nixon">1</td>
                                                <td>Adenilson</td>
                                                <td>adenilson.silva@ciss.com.br</td>
						<td>1234</td>
						<td data-order="1303686000">Mon 25th Apr 11</td>
					</tr>				
				</tbody>
			</table>
		</section>
	</div>	
</body>
</html>