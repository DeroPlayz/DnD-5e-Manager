import os
import re

def rename_files_and_folders_recursive(folder_path):
    """
    Goes through a folder and all its subfolders, renaming files and folders
    to remove spaces, remove underscores after non-closing non-letters and before capitals,
    and add underscores after closing characters and before capitals.
    """
    try:
        for root, dirs, files in os.walk(folder_path):
            # Rename directories
            for dir_name in dirs:
                old_dir_path = os.path.join(root, dir_name)
                # Remove spaces
                new_dir_name = dir_name.replace(" ", "")
                # Remove underscores between non-closing non-letters and capital letters.
                new_dir_name = re.sub(r'(?<![)\]])(\W)_([A-Z])', r'\1\2', new_dir_name)
                # Add underscores after closing characters and before capital letters.
                new_dir_name = re.sub(r'([)\]])([A-Z])', r'\1_\2', new_dir_name)
                new_dir_path = os.path.join(root, new_dir_name)
                if old_dir_path != new_dir_path:
                    try:
                        os.rename(old_dir_path, new_dir_path)
                        print(f"Renamed folder: {old_dir_path} to {new_dir_path}")
                    except Exception as e:
                        print(f"Error renaming folder {old_dir_path}: {e}")

            # Rename files
            for file_name in files:
                old_file_path = os.path.join(root, file_name)
                # Remove spaces
                new_file_name = file_name.replace(" ", "")
                # Remove underscores between non-closing non-letters and capital letters.
                new_file_name = re.sub(r'(?<![)\]])(\W)_([A-Z])', r'\1\2', new_file_name)
                # Add underscores after closing characters and before capital letters.
                new_file_name = re.sub(r'([)\]])([A-Z])', r'\1_\2', new_file_name)
                new_file_path = os.path.join(root, new_file_name)
                if old_file_path != new_file_path:
                    try:
                        os.rename(old_file_path, new_file_path)
                        print(f"Renamed file: {old_file_path} to {new_file_path}")
                    except Exception as e:
                        print(f"Error renaming file {old_file_path}: {e}")

    except FileNotFoundError:
        print(f"Error: Folder '{folder_path}' not found.")
    except Exception as e:
        print(f"An error occurred: {e}")

# Example usage:
folder_path = "C:/Users/matthew.ahwal/Documents/capstoneproject-e5-studios/app/src/main/assets"
rename_files_and_folders_recursive(folder_path)