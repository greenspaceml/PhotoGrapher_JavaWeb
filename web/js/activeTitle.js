
// Set bold for navigator item in header when in corresponding page 
function setBold() {
    // Get parth name in URL
    const url = window.location.pathname;
    
    // If path name in url is contact, set bold for contact item in navigator
    if (url.endsWith("contact")) {
        document.getElementById("contact").classList.add("active-title");
    }
    // If path name in url is home, set bold for home item in navigator
    else if (url.endsWith("front")) {
        document.getElementById("front").classList.add("active-title");
    }
    // If path name in url is gallery, set bold for corresponding gallery item in navigator
    else if (url.endsWith("gallery")) {
        //Get all params in URL
        let searchParams = new URLSearchParams(window.location.search);
        //Get value of id param
        var idGallery = searchParams.get('gid');
        // set Bold for element corresponding gallery 
        document.getElementById("gallery"+idGallery).classList.add("active-title");
    }
}
