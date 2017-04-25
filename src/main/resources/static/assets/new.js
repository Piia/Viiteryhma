(function () {
    'use strict';
    
    var $forms = document.getElementsByTagName('form');
    var $type = document.getElementById('reference-type');
    var $conditionals = document.getElementsByClassName('conditional');
    
    function onChangeType() {
        var $form;
        for (var i = 0; i < $forms.length; i += 1) {
            $form = $forms[i];
            console.log($form.getAttribute('id'), $type.value);
            if ($form.getAttribute('id') === 'references-' + $type.value) {
                $form.setAttribute('style', 'display: block;');
            } else {
                $form.setAttribute('style', 'display: none;');
            }
        }

    }
    
    function processConditional($conditional) {
       var $cases = $conditional.getElementsByClassName('case');
       
       for (var i = 0; i < 2; i += 1) {
           // Max 2 cases possible
           var $c = $cases[i];
           var $input = $c.getElementsByTagName("input")[0];
           
           var classes = $c.getAttribute('class') || '';
           
           if (classes.indexOf('selected') > -1) {
               $c.setAttribute('class', classes.replace('selected', '').trim());
               $input.removeAttribute('required');
           } else {
               $c.setAttribute('class', classes + ' selected');
               $input.setAttribute('required', 'required');
               $input.focus();
           }
       }
    }
        
    $type.addEventListener('change', onChangeType);
    
    for (var i = 0; i < $conditionals.length; i += 1) {
        var $links = $conditionals[i].getElementsByTagName('a');
        
        for (var j = 0; j < $links.length; j += 1) {
            $links[j].addEventListener('click', (function () {
                var $c = $conditionals[i];
                
                return function (e) {
                    e.preventDefault();
                    processConditional($c);
                };
            })());
        }
    }
    
})();