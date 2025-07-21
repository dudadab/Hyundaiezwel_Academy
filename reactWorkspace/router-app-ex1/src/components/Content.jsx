import React from 'react';
import { Link } from 'react-router-dom';

const Content = ({books}) => {
    return (
        <div>
            <hr/>
            <h2>전체 도서 정보</h2>
            <ul>
                {books.map((book) => (
                    <li key={book.id}>
                        <Link to={`/book/${book.id}`}>{book.title}</Link> 
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Content;