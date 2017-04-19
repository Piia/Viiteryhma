(function () {
    'use strict';
    
    var $forms = document.getElementsByTagName('form');
    var $type = document.getElementById('reference-type');
    
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
    
    $type.addEventListener('change', onChangeType);
})();