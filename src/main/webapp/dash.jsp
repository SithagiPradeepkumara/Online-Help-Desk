<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Help Desk</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f0f4f8; color: #333;">
    <header style="background-color: #007bff; color: white; padding: 10px 20px; display: flex; justify-content: space-between; align-items: center;">
        <h1 style="margin: 0;">Online help Desk</h1>
        <nav>
            <button onclick="location.href='newEmployee'" style="background-color: #007bff; color: white; border: none; padding: 10px 20px; border-radius: 5px; font-size: 16px; cursor: pointer; margin-left: 10px;">Contact US</button>
             <button onclick="location.href='list_employee'" style="background-color: #007bff; color: white; border: none; padding: 10px 20px; border-radius: 5px; font-size: 16px; cursor: pointer; margin-left: 10px;">All</button>
        </nav>
    </header>
    <main style="display: flex; justify-content: center; align-items: center; height: 80vh;">
        <section class="hero" style="text-align: center; background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 60%;">
            <img src="./assests/Image/B1.png"  alt="Help Desk Image" class="hero-image" style="width: 100%; max-width: 600px; height: auto; border-radius: 10px;">
            <div class="description" style="margin: 20px 0;">
                <p>Welcome to our Staff Management help Desk. We are here to assist you with your queries and provide support for your needs.</p>
            </div>
            
        </section>
    </main>
    <footer style="background-color: #007bff; color: white; text-align: center; padding: 10px 0; position: fixed; bottom: 0; width: 100%;">
        <p>&copy; 2024 Online help Desk  . All rights reserved.</p>
    </footer>
</body>
</html>
