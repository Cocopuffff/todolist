console.log("todoForm.js is working.")

newToDoForm.addEventListener('submit',(event) => {

    // Prevent default action of form submission so that I can do validation first
    event.preventDefault();

    // Select the inputs
    const title = document.querySelector('#titleInput').value;
    const description = document.querySelector('#descriptionInput').value;
    const targetdate = document.querySelector('#targetDate').value;


    //Validate date, if valid, create To Do object and POST to database
    //else, alert user of invalid date
    if (validateDate(targetdate)) {
        addToDo(title, description, targetdate);

        //reset input fields after submission
        const newToDoForm = document.querySelector('#newToDoForm');
        newToDoForm.reset();
    } else {
        alert("Target Date needs to be today or later!");
    }

});

//Validate date to return true (if InputDate is same date or later than dateToday) or false otherwise
function validateDate(targetdate){
    const dateToday = new Date();
    let month = dateToday.getMonth() + 1;
    let day = dateToday.getDate();
    let year = dateToday.getFullYear();

    const InputDate = new Date(targetdate);
    let inputDay = InputDate.getDate();
    let inputMonth = InputDate.getMonth() + 1;
    let inputYear = InputDate.getFullYear();

    console.log('Today\'s date: ' + dateToday);
    console.log('Input date: ' + InputDate);

    if (inputYear >= year && inputMonth >= month && inputDay >= day) {
        return true;
    } else {
        return false;
    }
}