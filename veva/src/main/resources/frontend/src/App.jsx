import { useState } from 'react'
import axios from 'axios'

function App() {
  const [count, setCount] = useState(0)

  axios.get('http://localhost:8080/users/getAll')
    .then((response) => {
      console.log(response)
    })
    .catch((error) => {
      console.log(error)
    })
    .finally(() => {
      console.log('complete')
    })

  return (
    <div>
      <h1>Veva Homepage</h1>
      <div>
        
      </div>
    </div>
  )
}

export default App
