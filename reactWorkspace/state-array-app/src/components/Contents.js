import React, {useState} from 'react';  
import '../App.css';

const Contents = () => {
    //let title = '지금 우리 학교는'
    let [titles, setTitle] = useState([
        '지금 우리 학교는',
        '올드보이'
    ]);

    let [item, setItem] = useState('');
    
    const onItemChange = (e) => {
        setItem(e.target.value);
    }

    const onItemAdd = () => {
        if(item===""){
            alert('추가할 내용을 입력하세요');
            document.getElementById('titleInput').focus();
        }else if(titles.includes(item)){
            alert('이미 추가된 내용입니다');
            setItem('');
            document.getElementById('titleInput').focus();
        }
        else{
            //setTitle(titles.concat(item));
            setTitle([...titles, item]);
            setItem('');   
        }
    }

    const onItemRemove = (title, index) => {
        setTitle(titles.filter((title)=> titles[index] !== title));
    }



    return (
        <div>
            <div className='header'>
                <h3>인기컨텐츠</h3>
            </div>
            <div className='contents'>
                {
                    titles.map((title, index) => {
                        <div key={index}>
                            <p>{index} : {title}
                            nbps;<button onClick={()=>onItemRemove(title,index)}>삭제</button></p>
                            <hr/>
                        </div>
                    })
                }
                <input type="text" id="titleInput" value={item} onChange={onItemChange}/>
                <button onClick={onItemAdd}>추가</button>
            </div>
            {/* <div>
                <p>{title[0]}</p>
                <hr/>
            </div>
            <div>
                <p>{title[1]}</p>
                <hr/>
            </div> */}
        </div>
    );
};

export default Contents;