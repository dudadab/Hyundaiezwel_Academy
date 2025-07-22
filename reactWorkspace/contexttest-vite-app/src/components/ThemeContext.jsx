import { createContext } from 'react';

export default createContext({
    mode: 'light', // 기본 모드
    togglMode: () => {} //모드 전환을 위한 핸들러
})