// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/** Fetches comments from the server and adds them to the DOM. */
function loadComments() {
  fetch('/list-comments').then(response => response.json()).then((comments) => {
    const commentListElement = document.getElementById('comment-list');
    comments.forEach((comment) => {
        commentListElement.appendChild(createCommentElement(comment));
    })
  });
}

/** Creates an element that represents a comment, including its delete button. */
function createCommentElement(comment) {
  const commentElement = document.createElement('div');
  commentElement.className = 'comment';

  const usernameElement = document.createElement('p');
  usernameElement.innerText = "Username: " + comment.username;

  const messageElement = document.createElement('p');
  messageElement.innerText = "Message: " + comment.message;

  const dateElement = document.createElement('p');
  dateElement.innerText = "Date posted: " + comment.date;

  const deleteButtonElement = document.createElement('button');
  deleteButtonElement.innerText = 'Delete';
  deleteButtonElement.addEventListener('click', () => {
    deleteComment(comment);

    // Remove the task from the DOM.
    commentElement.remove();
  });

  commentElement.appendChild(usernameElement);
  commentElement.appendChild(messageElement);
  commentElement.appendChild(dateElement);
  commentElement.appendChild(deleteButtonElement);
  commentElement.appendChild(document.createElement('hr'));

  return commentElement;
}

/** Tells the server to delete the task. */
function deleteComment(comment) {
  const params = new URLSearchParams();
  params.append('id', comment.id);
  fetch('/delete-comment', {method: 'POST', body: params});
}
