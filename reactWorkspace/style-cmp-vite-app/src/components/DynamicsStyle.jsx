import styled from 'styled-components';

export const PrimaryButton = styled.button`
    // color: ${
        props => props.primary ? 'red' : 'blue'
    };

    background: ${
        props => props.primary ? 'yellow' : 'pink'
    }
    
`;