<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navbar</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="dashboard.jsp">EcomLogistics</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="dashboard.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="users.jsp">Users</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="manager-details.jsp">Managers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="warehouses.jsp">Warehouses</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="shipments.jsp">Shipments</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="deliveries.jsp">Deliveries</a>
                    </li>
                    <% 
                        String username = (String) session.getAttribute("username");
                        if (username != null) { 
                    %>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Welcome, <%= username %></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logout.jsp">Logout</a>
                        </li>
                    <% 
                        } else { 
                    %>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                    <% 
                        } 
                    %>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Bootstrap Bundle with Popper (JavaScript) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
