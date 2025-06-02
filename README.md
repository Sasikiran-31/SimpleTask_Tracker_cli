# Java Command-Line Task Manager

This is a simple command-line task management application built in Java. It allows users to add, delete, list, update, and manage the status of tasks, with persistence to a JSON file.

This is a part of roadmap.sh task https://roadmap.sh/projects/task-tracker

## Features

* **Add Tasks**: Add new tasks with a description.
* **Delete Tasks**: Remove tasks by their unique ID.
* **List Tasks**: View all tasks or filter them by status (e.g., "done", "in-progress", "todo").
* **Update Tasks**: Modify the description of an existing task.
* **Update Task Status**: Mark tasks as "done", "in-progress", or "to-do".
* **Data Persistence**: All tasks are saved to and loaded from a `tasks.json` file, ensuring data is not lost between sessions.
* **Duplicate Task Prevention**: Prevents adding tasks with identical descriptions.

## How to Run

### Prerequisites

* Java Development Kit (JDK) 17 or higher
* Maven (for dependency management and building)

### Steps

1.  **Clone the Repository (or download the files):**
    ```bash
    git clone <repository_url>
    cd <project_directory>
    ```

2.  **Compile the Project:**
    Navigate to the root directory of the project (where `pom.xml` is located) and compile using Maven:
    ```bash
    mvn clean install
    ```

3.  **Run the Application:**
    After successful compilation, you can run the application from the target directory:
    ```bash
    java -jar target/demo-1.0-SNAPSHOT.jar
    ```
    Alternatively, you can run it directly from the project root if your IDE supports it or by executing the `Main` class:
    ```bash
    mvn exec:java -Dexec.mainClass="com.example.Main"
    ```

## Usage

Once the application is running, you will be prompted to enter commands. Here's a list of available commands:

* **`add task <description>`**: Adds a new task.
    * Example: `add task Buy groceries`

* **`delete <id>`**: Deletes a task by its ID.
    * Example: `delete 1`

* **`list`**: Lists all tasks.
    * Example: `list`

* **`list <status>`**: Lists tasks filtered by status. Valid statuses are `all`, `done`, `in-progress`, `to-do`.
    * Example: `list done`
    * Example: `list in-progress`

* **`update <id> <new_description>`**: Updates the description of a task.
    * Example: `update 1 Finish project report`

* **`mark-done <id>`**: Marks a task as "done".
    * Example: `mark-done 1`

* **`mark-in-progress <id>`**: Marks a task as "in-progress".
    * Example: `mark-in-progress 2`

* **`to-do <id>`**: Marks a task as "todo".
    * Example: `to-do 3`

* **`exit`**: Exits the application.
