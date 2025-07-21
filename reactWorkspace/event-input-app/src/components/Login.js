import React, {useState} from 'react';

const Login = () => {
    const [id, setId] = useState('');
    const [pwd, setPwd] = useState('');
    
    return (
        <div>
            <h2>ID : <input type="text" value={id} onChange={(e) => setId(e.target.value)} /></h2> 
            <h2>Pass :  <input type="password" value={pwd} onChange={(e) => setPwd(e.target.value)} /></h2>
            <button onClick={()=> {
                id === 'abcd' && pwd === '1234' ? alert("로그인 성공") : alert("로그인 실패");
                }}>확인</button>
            
        </div>
    );
};

export default Login;