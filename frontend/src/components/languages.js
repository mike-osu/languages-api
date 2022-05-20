    // src/components/languages.js

    import React from 'react'

    const Languages = ({ languages }) => {
      return (
        <div>
          <center><h1>Languages</h1></center>
          {languages.map((language) => (
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">{language.name}</h5>
                <h6 class="card-subtitle mb-2 text-muted">Number of speakers (millions): {language.speakers}</h6>
                <p class="card-text">{language.name}</p>
              </div>
            </div>
          ))}
        </div>
      )
    };

    export default Languages