import React, { useState } from "react";
import { Dialog, DialogTitle, DialogContent, DialogActions, Button } from "@mui/material";

const useConfirmDialog = () => {
   const [open, setOpen] = useState(false);
   const [dialogData, setDialogData] = useState({
      title: "",
      content: "",
      resolve: null, // Will store the promise resolver function
   });

   const showDialog = (title, content) => {
      return new Promise((resolve) => {
         setDialogData({ title, content, resolve });
         setOpen(true);
      });
   };

   const handleConfirm = () => {
      dialogData.resolve(true);
      setOpen(false);
   };

   const handleCancel = () => {
      dialogData.resolve(false);
      setOpen(false);
   };

   // Modal UI (Dialog UI)
   const ConfirmDialog = () => (
      <Dialog open={open} onClose={handleCancel}>
         <DialogTitle>{dialogData.title}</DialogTitle>
         <DialogContent>{dialogData.content}</DialogContent>
         <DialogActions>
            <Button onClick={handleCancel} color="primary">Cancel</Button>
            <Button onClick={handleConfirm} color="error">Confirm</Button>
         </DialogActions>
      </Dialog>
   );

   return { showDialog, ConfirmDialog };
};

export default useConfirmDialog;
