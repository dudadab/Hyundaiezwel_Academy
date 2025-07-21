import React, {useState} from 'react';

const Update = (props) => {
    const [title, setTitle] = useState(props.title);
    const [body, setBody] = useState(props.body);
    return (
         <article>
            <h2>Update</h2>
            {/* submit 이벤트의 기본 기능은 중지시킴 */}
            <form onSubmit={(event)=>{
                event.preventDefault();
                //submit 이벤트 발생시에 입력된 데이터 추출
                const title = event.target.title.value;
                const body = event.target.body.value;
                props.onUpdate(title, body); 
            }}>
                <p><input type="text" name="title" placeholder="title" value={props.title} onChange={
                    event=>{setTitle(event.target.value)}
                }/></p>
                <p><textarea name='body' placeholder='body' value={body} onChange={
                    event=>{setBody(event.target.value)}
                }/></p>
                <p><input type='submit' value='Create'/></p>
            </form>
        </article>
    );
};

export default Update;