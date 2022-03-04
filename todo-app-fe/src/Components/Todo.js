import React,{useEffect, useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button, Checkbox} from '@mui/material';
import Modal from '@mui/material/Modal';





export default function Todo() {
    const paperStyle ={padding:'50px 20px',width:600,margin: "20px auto"};
    const[task,setTask] = useState('')
    const[isDone,setDone] = useState(false)
    const[allTask,setAllTask] = useState([])
    const [checked, setChecked] = React.useState(false)
    const [open, setOpen] = React.useState(false)
  


    const handleClick =(e)=>{
        e.preventDefault()
        const tasktoadd={task,isDone}
        console.log(task)
        fetch("http://localhost:8080/save",{
            method: "POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(tasktoadd)
        }).then(()=>{
            console.log("NEW TASK ADDED");
        })
       
    }
    const handleClickupdate =(e)=>{
        e.preventDefault()
        const tasktoadd={task,isDone}
        console.log(task)
        fetch("http://localhost:8080/edit",{
            method: "POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(tasktoadd)
        }).then(()=>{
            console.log("NEW TASK UPDATED");
        })
       
    }

      
    useEffect(()=>{
        fetch("http://localhost:8080/get")
        .then(res=>res.json())
        .then((result)=>{
            setAllTask(result)
        }
    )
    },[])
    
    return (

    <Container>
        <Paper elevation={3} style ={paperStyle}>
            <h1 style={{color:"blue", textAlign:"center"}}><p>ADD TASK</p></h1>
        <Box
        component="form"
        sx={{
            '& > :not(style)': { m: 1 },
        }}
        noValidate
        autoComplete="off"
        >
        <TextField id="outlined-basic" label="Task to do" variant="outlined" fullWidth
        value={task}
        onChange={(e)=>setTask(e.target.value)}
        />
        </Box>

        <Button variant="contained" onClick = {handleClick}>Add Task</Button>
        </Paper>

        <Paper elevation={3} style ={paperStyle}>
            {allTask.map(task=>(
                <Paper elevation={6} style={{margin: "10px" , padding:"15px", alignContent:"flex-start"}} key = {task.id}>
                        Task to do : {task.task}
                        <p></p>
                        <Button variant="contained" onClick={console.log("d")} >Editar</Button>
                      


                        <Checkbox
                            checked={task.isDone}
                            onChange={console.log("Missin THING")}//handleChangeCheck
                            inputProps={{ 'aria-label': 'controlled' }}
                            />
                </Paper>
            ))}



        </Paper>
    </Container>
  );
}
