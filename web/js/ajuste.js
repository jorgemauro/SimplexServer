$('#adiciona').on('click',function(){
    var i = $('.restrict').length+1;
    console.log(i);
    return $('<div><label for="restricoes.'+i+'">Tamanho das restrições </label> <input id="restricoes.'+i+'" name="restricoes" type="text" class="validate restrict" size = "2" required = "true"/></div>').appendTo($('#R'));

});