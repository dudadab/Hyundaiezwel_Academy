import { useContext } from "react";
import { Button } from "@mui/material";
import ThemeContext from "./components/ThemeContext";

export default function HookThemeButton(){
    const {mode, togglMode} = useContext(ThemeContext);
    return(
        <Button onClick={togglMode} variant ="contained">
            Mode {mode}
        </Button>
    )
}