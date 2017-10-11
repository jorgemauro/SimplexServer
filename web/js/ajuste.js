$('#adiciona').on('click',function(){
    var i = $('.restrict').length+1;
    $('#n_restricao').val(i);
    console.log(i);
    return $('<div><input id="restricoes.'+i+'" name="restricoes" type="text" class="validate restrict" size = "2" required = "true"/></div>').appendTo($('#R'));

});