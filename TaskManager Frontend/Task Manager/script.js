document.addEventListener("DOMContentLoaded", fetchTasks);

async function fetchTasks() {
    try {
        const response = await fetch("http://localhost:8080/tasks");
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        
        const tasks = await response.json();
        const taskList = document.getElementById("taskList");
        taskList.innerHTML = "";
        
        tasks.forEach((task) => {
            const li = document.createElement("li");
            li.classList.add("task-item");
            li.innerHTML = `
                <span class="task-text"><strong>${task.title}</strong> - ${task.description} - 
                <span class="status" style="color: ${task.completed ? 'limegreen' : 'orangered'};">
                    ${task.completed ? 'Completed' : 'Pending'}
                </span></span>
                <button class="completeBtn" onclick="markComplete(${task.id})">✔ Mark Complete</button>
                <button class="deleteBtn" onclick="deleteTask(${task.id})">❌ Delete</button>
            `;
            taskList.appendChild(li);
        });
    } catch (error) {
        console.error("Error fetching tasks:", error);
    }
}

async function addTask() {
    const title = document.getElementById("taskTitle").value.trim();
    const description = document.getElementById("taskDescription").value.trim();
    if (!title || !description) {
        alert("Title and description cannot be empty!");
        return;
    }
    try {
        const response = await fetch("http://localhost:8080/tasks", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ title, description, completed: false })
        });
        if (!response.ok) throw new Error("Failed to add task");
        document.getElementById("taskTitle").value = "";
        document.getElementById("taskDescription").value = "";
        fetchTasks();
    } catch (error) {
        console.error("Error adding task:", error);
        alert("An error occurred while adding the task!");
    }
}

async function markComplete(taskId) {
    try {
        const response = await fetch(`http://localhost:8080/tasks/${taskId}/complete`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" }
        });
        if (!response.ok) throw new Error(`Failed to mark task as complete. Status: ${response.status}`);
        fetchTasks();
    } catch (error) {
        console.error("Error marking task as complete:", error);
    }
}

async function deleteTask(id) {
    try {
        const response = await fetch(`http://localhost:8080/tasks/${id}`, { method: "DELETE" });
        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        fetchTasks();
    } catch (error) {
        console.error("Error deleting task:", error);
    }
}

// Add CSS for styling
document.head.insertAdjacentHTML("beforeend", `
    <style>
        body {
            background-color: #121212;
            color: white;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        #taskList {
            list-style: none;
            padding: 0;
            width: 60%;
        }
        .task-item {
            background: #1e1e1e;
            padding: 10px;
            margin: 10px 0;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
            transition: transform 0.2s;
        }
        .task-item:hover {
            transform: scale(1.05);
            box-shadow: 0 0 15px rgba(255, 255, 255, 0.2);
        }
        .completeBtn, .deleteBtn {
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
            transition: background 0.3s, transform 0.2s;
        }
        .completeBtn {
            background-color: #28a745;
            color: white;
        }
        .completeBtn:hover {
            background-color: #218838;
            transform: scale(1.1);
        }
        .deleteBtn {
            background-color: #dc3545;
            color: white;
        }
        .deleteBtn:hover {
            background-color: #c82333;
            transform: scale(1.1);
        }
    </style>
`);





// Previous code working fine




// document.addEventListener("DOMContentLoaded", fetchTasks);

// async function fetchTasks() {
//     try {
//         const response = await fetch("http://localhost:8080/tasks");
//         if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
        
//         const tasks = await response.json();
//         const taskList = document.getElementById("taskList");
//         taskList.innerHTML = "";
        
//         tasks.forEach((task) => {
//             const li = document.createElement("li");
//             li.classList.add("task-item");
//             li.innerHTML = `
//                 <span><strong>${task.title}</strong> - ${task.description} - 
//                 <span style="color: ${task.completed ? 'green' : 'red'};">
//                     ${task.completed ? 'Completed' : 'Pending'}
//                 </span></span>
//                 <button class="completeBtn" onclick="markComplete(${task.id})">✔ Mark Complete</button>
//                 <button class="deleteBtn" onclick="deleteTask(${task.id})">❌ Delete</button>
//             `;
//             taskList.appendChild(li);
//         });
//     } catch (error) {
//         console.error("Error fetching tasks:", error);
//     }
// }

// // ✅ Add the `markComplete` function here
// async function markComplete(taskId) {
//     try {
//         const response = await fetch(`http://localhost:8080/tasks/${taskId}/complete`, {
//             method: "PUT",
//             headers: { "Content-Type": "application/json" }
//         });

//         if (!response.ok) {
//             throw new Error(`Failed to mark task as complete. Status: ${response.status}`);
//         }

//         console.log(`Task ${taskId} marked as complete.`);
//         fetchTasks(); // Refresh the list
//     } catch (error) {
//         console.error("Error marking task as complete:", error);
//     }
// }

// async function addTask() {
//     const title = document.getElementById("taskTitle").value.trim();
//     const description = document.getElementById("taskDescription").value.trim();
//     if (!title || !description) {
//         alert("Title and description cannot be empty!");
//         return;
//     }
//     try {
//         const response = await fetch("http://localhost:8080/tasks", {
//             method: "POST",
//             headers: { "Content-Type": "application/json" },
//             body: JSON.stringify({ title, description, completed: false })
//         });
//         if (!response.ok) throw new Error("Failed to add task");
//         document.getElementById("taskTitle").value = "";
//         document.getElementById("taskDescription").value = "";
//         fetchTasks();
//     } catch (error) {
//         console.error("Error adding task:", error);
//         alert("An error occurred while adding the task!");
//     }
// }

// async function deleteTask(id) {
//     try {
//         const response = await fetch(`http://localhost:8080/tasks/${id}`, { method: "DELETE" });
//         if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
//         fetchTasks();
//     } catch (error) {
//         console.error("Error deleting task:", error);
//     }
// }
// async function markComplete(taskId) {
//     try {
//         const response = await fetch(`http://localhost:8080/tasks/${taskId}/complete`, {
//             method: "PUT",
//             headers: { "Content-Type": "application/json" }
//         });

//         if (!response.ok) {
//             throw new Error(`Failed to mark task as complete. Status: ${response.status}`);
//         }

//         const updatedTask = await response.json();
//         console.log("Updated Task:", updatedTask); // Debugging log

//         fetchTasks(); // Refresh the list
//     } catch (error) {
//         console.error("Error marking task as complete:", error);
//     }
// }
