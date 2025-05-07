import os
import json

def remove_minify_from_name(path):
    """
    Removes "_minify" from the file or folder name if it exists.
    
    Args:
        path (str): The path of the file or folder.
    
    Returns:
        str: The path with "_minify" removed from the name.
    """
    # Get the directory and the name (file or folder)
    dir_name, base_name = os.path.split(path)
    
    # Remove "_minify" from the base name
    new_base_name = base_name.replace("_minify", "").replace("Check out my 5e armor creation! This is ", "")
    
    # Return the new path with the modified name
    return os.path.join(dir_name, new_base_name)

def convert_cah_to_json(directory):
    """
    Converts all .cah files to .json files within a directory and its subfolders.
    Renames folders with identical names to files by appending "subraces".
    Also removes "_minify" from any file or folder name.

    Args:
        directory (str): The path to the directory to scan.
    """
    for root, dirs, files in os.walk(directory):
        # Handle renaming folders
        for folder_name in dirs:
            folder_path = os.path.join(root, folder_name)
            new_folder_path = remove_minify_from_name(folder_path)
            
            if folder_path != new_folder_path:
                print(f"Renaming folder: {folder_path} -> {new_folder_path}")
                os.rename(folder_path, new_folder_path)

        # Handle renaming files and processing .cah files
        for filename in files:
            file_path = os.path.join(root, filename)
            new_file_path = remove_minify_from_name(file_path)
            
            if file_path != new_file_path:
                print(f"Renaming file: {file_path} -> {new_file_path}")
                os.rename(file_path, new_file_path)
                
                filename = os.path.basename(new_file_path)  # Update filename after renaming

            # Process .cah files and convert to .json
            if filename.endswith(".cah"):
                cah_filepath = new_file_path
                json_filepath = os.path.splitext(cah_filepath)[0] + ".json"

                # Check for folder with identical name (same base name as the .cah file)
                folder_name = os.path.splitext(filename)[0]  # This extracts the file name without extension
                folder_path = os.path.join(root, folder_name)
            
                if os.path.exists(folder_path) and os.path.isdir(folder_path):
                    print(f"There is a folder with the same name as a file: {folder_path}")
                    new_folder_path = folder_path + "Subraces"
                    if not os.path.exists(new_folder_path):  # Prevents overwriting
                        os.rename(folder_path, new_folder_path)
                        print(f"Renamed folder: {folder_path} -> {new_folder_path}")
                    else:
                        print(f"Folder {new_folder_path} already exists. Skipping renaming.")

                try:
                    with open(cah_filepath, 'r') as cah_file:
                        data = json.load(cah_file)

                    with open(json_filepath, 'w') as json_file:
                        json.dump(data, json_file, indent=4)

                    os.remove(cah_filepath)

                    print(f"Converted: {cah_filepath} -> {json_filepath}")

                except json.JSONDecodeError:
                    print(f"Error: {cah_filepath} is not valid JSON. Skipping.")
                except Exception as e:
                    print(f"Error processing {cah_filepath}: {e}")

if __name__ == "__main__":
    directory_to_scan = "C:/Users/matthew.ahwal/Documents/capstoneproject-e5-studios/app/src/main/assets"
    
    if os.path.exists(directory_to_scan):
        convert_cah_to_json(directory_to_scan)
    else:
        print(f"Error: Directory '{directory_to_scan}' not found.")
