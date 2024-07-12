document.addEventListener('DOMContentLoaded', function() {
    

    let currentTheme = getTheme();
    changeTheme(currentTheme);

    function changeTheme(initialTheme) {
        currentTheme = initialTheme;
        // Set the initial theme to the web page
        document.querySelector('html').classList.add(currentTheme);

        // Set the Listener to change the theme
        const changeThemeButton = document.querySelector("#dark-mode-toggle");
        //Change the text of button
        

        if (changeThemeButton) {
            changeThemeButton.addEventListener("click", () => {
                const oldTheme = currentTheme;
                console.log("Change theme button clicked");
                if (currentTheme === "dark") {
                    currentTheme = "light";
                } else {
                    currentTheme = "dark";
                }
                setTheme(currentTheme);
                document.querySelector('html').classList.remove(oldTheme);
                document.querySelector('html').classList.add(currentTheme);
            });
        } else {
            console.error('Element with id "dark-mode-toggle" not found');
        }
    }

    // Set theme to localStorage
    function setTheme(theme) {
        localStorage.setItem("theme", theme);
    }

    // Get theme from localStorage
    function getTheme() {
        let theme = localStorage.getItem("theme");
        return theme ? theme : "light";
    }
});
