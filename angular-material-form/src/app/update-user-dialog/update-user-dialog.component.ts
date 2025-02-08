import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from '../user.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { phoneValidator } from '../user-form/user-form.component';

@Component({
  selector: 'app-update-user-dialog',
  templateUrl: './update-user-dialog.component.html',
  styleUrls: ['./update-user-dialog.component.css']
})
export class UpdateUserDialogComponent {
  updateForm: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<UpdateUserDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: User,
    private formBuilder: FormBuilder
  ) {
    this.updateForm = this.formBuilder.group({
      firstName: [data.firstName, Validators.required],  // Pre-fill with existing name
      lastName: [data.lastName, Validators.required],
      address: [data.address, Validators.required],
      phone: [data.phone, [Validators.required, phoneValidator()]],
      email: [data.email, [Validators.required, Validators.email]]
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onUpdateClick(): void {
    if (this.updateForm.valid) {
      const updatedUser: User = {
        id: this.data.id,
        firstName: this.updateForm.value.firstName,
        lastName: this.updateForm.value.lastName,
        address: this.updateForm.value.address,
        phone: this.updateForm.value.phone,
        email: this.updateForm.value.email
      };
      this.dialogRef.close(updatedUser); // Pass the updated user data back
    }
  }
}


// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-update-user-dialog',
//   templateUrl: './update-user-dialog.component.html',
//   styleUrl: './update-user-dialog.component.css'
// })
// export class UpdateUserDialogComponent {

// }
