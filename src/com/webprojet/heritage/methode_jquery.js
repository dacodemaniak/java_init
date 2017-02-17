/**
 * En jQuery, les méthodes sont définies avec le même nom, mais des signatures
 * 	différentes et se comportent donc différemment...
 * Par exemple : <div class="container" id="principal" title="">Coucou</div>
**/
$("#principal").attr("title","Titre de la DIV");
console.log("Titre : " + $("#principal").attr("title"));