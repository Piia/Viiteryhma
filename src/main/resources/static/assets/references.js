(function () {
    'use strict';
    
    var $references = document.getElementsByClassName('references');
    var $filterInput = document.getElementById('filter');
    
    function filterReferences(str) {
        str = str.toLowerCase();
        
        function getReferenceFields($ref) {
            var fields = [];
            
            for (var i = 0; i < $ref.children.length; i += 1) {
                var $el = $ref.children[i];
                
                if ($el.tagName === 'LI') {
                    fields.push($el);
                }
                
                fields.concat(getReferenceFields($el));
            }
            
            return fields;
        }
        
        function anyFieldMatchesString($fields) {
            var match = false;
            
            for (var i = 0; i < $fields.length; i += 1) {
                // Case insensitive
                var fieldText = $fields[i].innerText.toLowerCase(); 
                
                if (fieldText.match(str) !== null) {
                    match = true;
                    break;
                }
            }
            
            return match;
        }
        
        function setVisible($el) {
            $el.setAttribute('style', 'display: block;')
        }
        
        function setHidden($el) {
            $el.setAttribute('style', 'display: none;');
        }
        
        for (var i = 0; i < $references.length; i += 1) {
            var $ref = $references[i];
            
            if (str === '') {
                setVisible($ref);
                continue;
            }
            
            var $fields = getReferenceFields($ref);
                        
            if (anyFieldMatchesString($fields)) {
                setVisible($ref);
            } else {
                setHidden($ref);
            }
        }
    }
    
    function onChangeFilterInput() {
        filterReferences($filterInput.value);
    }
    
    $filterInput.addEventListener('input', onChangeFilterInput);
})();