document.addEventListener('DOMContentLoaded', function()
{
    var copyButton = document.getElementById("copy");
    if (copyButton)
    {
        copyButton.addEventListener('click', function()
        {
 			  var copyText = document.getElementById("shortURL");
			  copyText.select();
			  copyText.setSelectionRange(0, 99999);
              document.execCommand("copy");
			  alert("Copied Short URL: " + copyText.value);
        });
    }
    
    var shortURL = document.getElementById("shortURL");
    if(shortURL.value != null)
    {
		shortURL.style.color = "red";
		setTimeout(function(){shortURL.style.color = "black";},500);
	}
});