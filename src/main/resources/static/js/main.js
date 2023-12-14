function GerarMatricula(){

    var aleatorio = Math.floor(Math.random() * 1500000);
    document.getElementById('matricula').value = (aleatorio);
}

function limpar() {
    $('#lista li').show();
}
function filtrar() {
    var termo = $('#pesquisa').val().toUpperCase();
    $('#lista li').each(function() {
        if($(this).html().toUpperCase().indexOf(termo) === -1) {
            $(this).hide();
        }
    });
}