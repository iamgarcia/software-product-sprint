// // Copyright 2019 Google LLC
// //
// // Licensed under the Apache License, Version 2.0 (the "License");
// // you may not use this file except in compliance with the License.
// // You may obtain a copy of the License at
// //
// //     https://www.apache.org/licenses/LICENSE-2.0
// //
// // Unless required by applicable law or agreed to in writing, software
// // distributed under the License is distributed on an "AS IS" BASIS,
// // WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// // See the License for the specific language governing permissions and
// // limitations under the License.

// package com.google.sps.servlets;

// import com.google.sps.data.Comment;
// import com.google.gson.Gson;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// /** Servlet that returns some example content. TODO: modify this file to handle comments data */
// @WebServlet("/comment")
// public class DataServlet extends HttpServlet {

//     private List<Comment> comments;

//     @Override
//     public void init() {
//         comments = new ArrayList<>();

//         Comment userComment1 = new Comment("Alex", "Hello world!");
//         Comment userComment2 = new Comment("Fernando", "Welcome to the chat!");
//         Comment userComment3 = new Comment("Ace", "Glad to have you join us!0");
//         comments.add(userComment1);
//         comments.add(userComment2);
//         comments.add(userComment3);
//     }

//     @Override
//     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//         // Get the input from the form.
//         String username = request.getParameter("username-text-input");
//         String message = request.getParameter("message-text-input");

//         // Respond with the result.
//         response.setContentType("text/html;");
//         response.getWriter().println(username + " " + message);
//     }

//     @Override
//     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//         // Convert the quotes to JSON
//         String json = convertToJsonUsingGson(comments);
        
//         // Send the JSON as the response
//         response.setContentType("application/json;");
//         response.getWriter().println(json);
//     }

//     /**
//     * Converts a ServerStats instance into a JSON string using the Gson library. Note: We first added
//     * the Gson library dependency to pom.xml.
//     */
//     private String convertToJsonUsingGson(List<Comment> comments) {
//         Gson gson = new Gson();
//         String json = gson.toJson(comments);
//         return json;
//     }

// }