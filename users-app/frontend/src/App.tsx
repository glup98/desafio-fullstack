import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Users } from '@/pages/Users';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Users />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
