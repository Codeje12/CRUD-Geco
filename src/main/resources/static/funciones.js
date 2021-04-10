$(function(){
	var nombreProducto,stock,costo,venta,descripcion;
	$('.btnAction').on('click',function(){
		nombreProducto = $(".nombreProducto").val();
		stock = $(".stock").val();
		costo = $(".costo").val();
		venta = $(".venta").val();
		if(nombreProducto.length == 0 || stock.length == 0 || costo.length == 0
			||venta.length==0 || descripcion.length==0){
			alert("no puede dejar campos vacios");
		}
		location.href="/listar";
	});
});

$('.btnCancel').on('click',function(){
		location.href="/listar";
	});

function eliminar(id){
	swal({
  title: "¿Desea eliminar el registro?",
  text: "Se eliminara de forma permanente de la base de datos.!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/delete/" + id ,
		success: function(res){
			console.long(res);
		}
	});
    swal("Listo, registro eliminado con exito.", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/listar";
		}
});
  } else {
    swal("No eliminaste el registro!");
  }
});
}