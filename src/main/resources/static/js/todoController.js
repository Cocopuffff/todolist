console.log("todoController.js is working.");

const displayAPI = 'http://localhost:8080/todolist/all';
const addAPI = 'http://localhost:8080/todolist/add';

let todoList = [];

// Invoke GET API  to display to do's in a table format
function displayToDo() {
    fetch(displayAPI)
        .then(response => response.json())
        .then(function(data) {
            console.log("Received data");
            console.log(data);
            data.forEach(function(todo) {
                const dateObj = new Date(todo.targetDate);
                const formattedDate = dateObj.toLocaleDateString('en-GB');
                const toDoObject = {
                id: todo.id,
                title: todo.title,
                description: todo.description,
                targetdate: formattedDate
                };
                todoList.push(toDoObject);
            });
            console.log(todoList);
            renderToDoList();
        })
        .catch(function(error) {
        console.log(error);
        });
}

//Create table of To Do's
function renderToDoList() {
    let display = `
    <div class="container">
        <table class="table table-hover">
            <thead>
                <tr class="table-success">
                    <th scope="col">Title</th>
                    <th scope="col">Description</th>
                    <th scope="col">Target Date</th>
                    <th scope="col">Delete</th>
                </tr>
            </thead>`;

    for (let i = 0; i < todoList.length; i++) {
        display += `
        <tbody class="table-striped">
            <tr>
                <td>${todoList[i].title}</td>
                <td>${todoList[i].description}</td>
                <td>${todoList[i].targetdate}</td>
                <td>
                    <button type="button" class="btn btn-danger delete" id="${todoList[i].id}" onClick="deleteToDo(this.id)">X</button>
                </td>
            </tr>
        `
    }
    display += `
            </tbody>
        </table>
    </div>`;

    document.querySelector('#ToDoList').innerHTML = display;
}


//Add new To Do to the database when the user clicks on add button in new.html
function addToDo(title, description, targetdate) {

    const formData = new FormData();
    formData.append('title', title);
    formData.append('description', description);
    formData.append('targetdate', targetdate);

    fetch(addAPI, {
        method: 'POST',
        body: formData
    })
        .then(function(response){
            console.log(response.status);
            if (response.ok) {
                alert("Successfully Added TODO!");
            }
            else {
               alert("Something went wrong. Please try again.");
            }
        })
        .catch((error) => {
            console.error('Error' + error);
            alert("Error adding TODO to database!");
        });
}

//const deleteButtons = document.getElementsByClassName('delete');
//console.log(deleteButtons);
//const deleteButtonsArray = Array.from(document.querySelectorAll('.delete'));
//console.log(deleteButtonsArray);
//deleteButtonsArray.forEach(button => {
//    button.addEventListener('click', function() {
//        // Handle the button click event here
//        //const id = this.getAttribute('id');
//        console.log(this.id);
//    });
//});

function deleteToDo(clicked_id) {
    let deleteAPI = 'http://localhost:8080/todolist/' + clicked_id;
    fetch(deleteAPI, {method: 'DELETE'})
        .then(function(response) {
        console.log(response.status); // Will show you the status
        if (response.ok) {
             alert("Successfully deleted TODO!");
             todoList = [];
             displayToDo();
        }
        else {
            alert("Something went wrong. Please try again");
        }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error deleting TODO");
        });
}