$(function(){
	var nombreProducto,stock,costo,venta,descripcion;
	$('.btnAction').on('click',function(){
		nombreProducto = $(".nombreProducto").val();
		stock = $(".stock").val();
		costo = $(".costo").val();
		venta = $(".venta").val();
		console.log(nombreProducto);
		if(nombreProducto.length == 0 || stock.length == 0 || costo.length == 0
			||venta.length==0 || descripcion.length==0){
			alert("no puede dejar campos vacios");
			location.href="/index";
		}
	});
});


function eliminar(id){
	swal({
  title: "¿Desea eliminar el archivo?",
  text: "Once deleted, you will not be able to recover this imaginary file!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"eliminar/"+id,
		success: function(res){
			console.long(res);
		}
	});
    swal("Poof! Your imaginary file has been Eliminado!", {
      icon: "success",
    }).then((ok)=>{
		location.href="/listar";
		});
  } else {
    swal("Your imaginary file is safe!");
  }
});
}