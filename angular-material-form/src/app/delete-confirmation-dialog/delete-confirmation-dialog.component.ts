import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from '../user.model';

@Component({
  selector: 'app-delete-confirmation-dialog',
  templateUrl: './delete-confirmation-dialog.component.html',
  styleUrls: ['./delete-confirmation-dialog.component.css']
})
export class DeleteConfirmationDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<DeleteConfirmationDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: User
  ) {}

  onNoClick(): void {
    this.dialogRef.close(false); // Return false if cancelled
  }

  onConfirmClick(): void {
    this.dialogRef.close(true);  // Return true if confirmed
  }
}


// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-delete-confirmation-dialog',
//   templateUrl: './delete-confirmation-dialog.component.html',
//   styleUrl: './delete-confirmation-dialog.component.css'
// })
// export class DeleteConfirmationDialogComponent {

// }
